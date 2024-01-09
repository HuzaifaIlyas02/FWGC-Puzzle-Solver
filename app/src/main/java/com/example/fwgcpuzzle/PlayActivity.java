package com.example.fwgcpuzzle;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.Queue;

public class PlayActivity extends AppCompatActivity {
    Button wolf,goat,cabbage,himself,reset;
    TextView f1,f2,w1,w2,g1,g2,c1,c2;
    private AlertDialog.Builder alert;
    int x=0;
    int solutionLength;
    long startTime;
    int numberOfQueueOps;
    int maxQueueSize;
    Queue<String> moveQueue = new LinkedList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        wolf=(Button)findViewById(R.id.wolf);
        goat=(Button)findViewById(R.id.goat);
        cabbage=(Button)findViewById(R.id.cabbage);
        himself=(Button)findViewById(R.id.himself);
        reset=(Button)findViewById(R.id.reset);
        f1=(TextView) findViewById(R.id.f1);
        f2=(TextView)findViewById(R.id.f2);
        w1=(TextView)findViewById(R.id.w1);
        w2=(TextView)findViewById(R.id.w2);
        g1=(TextView)findViewById(R.id.g1);
        g2=(TextView)findViewById(R.id.g2);
        c1=(TextView)findViewById(R.id.c1);
        c2=(TextView)findViewById(R.id.c2);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.setVisibility(View.VISIBLE);
                f2.setVisibility(View.INVISIBLE);
                w1.setVisibility(View.VISIBLE);
                w2.setVisibility(View.INVISIBLE);
                g1.setVisibility(View.VISIBLE);
                g2.setVisibility(View.INVISIBLE);
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.INVISIBLE);
            }
        });
        View.OnClickListener l=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(fwgcplay.this, view.getId(), Toast.LENGTH_SHORT).show();
                solutionLength++;

                // Increment number of queue operations for each move
                numberOfQueueOps += 2; // Assuming each move involves enqueue and dequeue

                // Calculate max queue size
                maxQueueSize = Math.max(maxQueueSize, moveQueue.size());

                // Record the move in the queue
                moveQueue.offer(getMoveName(view.getId()));

                if(view.getId()==R.id.wolf)
                {
                    if(f2.getVisibility()==View.INVISIBLE)
                    {
                        f2.setVisibility(View.VISIBLE);
                        f1.setVisibility(View.INVISIBLE);
                        x++;
                    }
                    else{
                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.INVISIBLE);
                    }
                    if(w1.getVisibility()==View.VISIBLE)
                    {
                        w1.setVisibility(View.INVISIBLE);
                        w2.setVisibility(View.VISIBLE);
                    }
                    else{
                        w2.setVisibility(View.INVISIBLE);
                        w1.setVisibility(View.VISIBLE);
                    }

                    if(!check(f1, f2, w1, w2, g1, g2, c1, c2))
                    {
                        if(w2.getVisibility()==View.VISIBLE)
                        {
                            w2.setVisibility(View.INVISIBLE);
                            w1.setVisibility(View.VISIBLE);
                            if(f1.getVisibility()!=View.VISIBLE){
                                f1.setVisibility(View.VISIBLE);
                                f2.setVisibility(View.INVISIBLE);
                            }else{
                                f2.setVisibility(View.VISIBLE);
                                f1.setVisibility(View.INVISIBLE);
                            }
                        }
                        else{
                            w1.setVisibility(View.INVISIBLE);
                            w2.setVisibility(View.VISIBLE);
                        }
                    }
                    if(f2.getVisibility()==View.VISIBLE && w2.getVisibility()==View.VISIBLE && g2.getVisibility()==View.VISIBLE && c2.getVisibility()==View.VISIBLE)
                    {
                        alertbox();

                    }
                }
                else if(view.getId()==R.id.goat)
                {
                    if(f2.getVisibility()==View.INVISIBLE)
                    {
                        f2.setVisibility(View.VISIBLE);
                        f1.setVisibility(View.INVISIBLE);

                    }
                    else{
                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.INVISIBLE);
                    }
                    if(g1.getVisibility()==View.VISIBLE)
                    {
                        g1.setVisibility(View.INVISIBLE);
                        g2.setVisibility(View.VISIBLE);
                    }
                    else{
                        g2.setVisibility(View.INVISIBLE);
                        g1.setVisibility(View.VISIBLE);
                    }

                    if(!check(f1, f2, w1, w2, g1, g2, c1, c2))
                    {
                        if(g2.getVisibility()==View.VISIBLE)
                        {
                            g2.setVisibility(View.INVISIBLE);
                            g1.setVisibility(View.VISIBLE);
                            if(f1.getVisibility()!=View.VISIBLE){
                                f1.setVisibility(View.VISIBLE);
                                f2.setVisibility(View.INVISIBLE);
                            }
                            else{
                                f2.setVisibility(View.VISIBLE);
                                f1.setVisibility(View.INVISIBLE);
                            }
                        }
                        else{
                            g1.setVisibility(View.INVISIBLE);
                            g2.setVisibility(View.VISIBLE);
                        }
                    }
                    if(f2.getVisibility()==View.VISIBLE && w2.getVisibility()==View.VISIBLE && g2.getVisibility()==View.VISIBLE && c2.getVisibility()==View.VISIBLE)
                    {
                        alertbox();

                    }

                }
                else if(view.getId()==R.id.cabbage){
                    if(f2.getVisibility()==View.INVISIBLE)
                    {
                        f2.setVisibility(View.VISIBLE);
                        f1.setVisibility(View.INVISIBLE);
                        x++;
                    }
                    else{
                        f1.setVisibility(View.VISIBLE);
                        f2.setVisibility(View.INVISIBLE);
                    }
                    if(c1.getVisibility()==View.VISIBLE)
                    {
                        c1.setVisibility(View.INVISIBLE);
                        c2.setVisibility(View.VISIBLE);
                    }
                    else{
                        c2.setVisibility(View.INVISIBLE);
                        c1.setVisibility(View.VISIBLE);
                    }

                    if(!check(f1, f2, w1, w2, g1, g2, c1, c2))
                    {
                        if(c2.getVisibility()==View.VISIBLE)
                        {
                            c2.setVisibility(View.INVISIBLE);
                            c1.setVisibility(View.VISIBLE);
                            if(f1.getVisibility()!=View.VISIBLE){
                                f1.setVisibility(View.VISIBLE);
                                f2.setVisibility(View.INVISIBLE);
                            }
                            else{
                                f2.setVisibility(View.VISIBLE);
                                f1.setVisibility(View.INVISIBLE);
                            }
                        }
                        else{
                            c1.setVisibility(View.INVISIBLE);
                            c2.setVisibility(View.VISIBLE);
                        }
                    }
                    if(f2.getVisibility()==View.VISIBLE && w2.getVisibility()==View.VISIBLE && g2.getVisibility()==View.VISIBLE && c2.getVisibility()==View.VISIBLE)
                    {
                        alertbox();

                    }
                }
                else if(view.getId()==R.id.himself){
                    if(f1.getVisibility()==View.VISIBLE)
                    {
                        f1.setVisibility(View.INVISIBLE);
                        f2.setVisibility(View.VISIBLE);
                    }
                    else{
                        f2.setVisibility(View.INVISIBLE);
                        f1.setVisibility(View.VISIBLE);
                    }

                    if(!check(f1, f2, w1, w2, g1, g2, c1, c2))
                    {
                        if(f2.getVisibility()==View.VISIBLE)
                        {
                            f2.setVisibility(View.INVISIBLE);
                            f1.setVisibility(View.VISIBLE);
                        }
                        else{
                            f1.setVisibility(View.INVISIBLE);
                            f2.setVisibility(View.VISIBLE);
                        }
                    }
                    if(f2.getVisibility()==View.VISIBLE && w2.getVisibility()==View.VISIBLE && g2.getVisibility()==View.VISIBLE && c2.getVisibility()==View.VISIBLE)
                    {
                        alertbox();

                    }
                }
            }
        };
        himself.setOnClickListener(l);
        wolf.setOnClickListener(l);
        goat.setOnClickListener(l);
        cabbage.setOnClickListener(l);

        startTime = SystemClock.elapsedRealtime();


    }

    private void resetGame() {
        // ... (existing code)

        // Clear the move queue and reset statistics
        moveQueue.clear();
        solutionLength = 0;
        numberOfQueueOps = 0;
        maxQueueSize = 0;

        // Record the start time when the game is reset
        startTime = SystemClock.elapsedRealtime();
    }

    private String getMoveName(int viewId) {
        if (viewId == R.id.himself) {
            return "Himself";
        } else if (viewId == R.id.wolf) {
            return "Wolf";
        } else if (viewId == R.id.goat) {
            return "Goat";
        } else if (viewId == R.id.cabbage) {
            return "Cabbage";
        } else {
            return "";
        }
    }
    boolean check(TextView f1,TextView f2,TextView w1,TextView w2,TextView g1,TextView g2,TextView c1,TextView c2)
    {

        if((f1.getVisibility()!=View.VISIBLE && w1.getVisibility()==View.VISIBLE && g1.getVisibility()==View.VISIBLE) || (f2.getVisibility()!=View.VISIBLE && w2.getVisibility()==View.VISIBLE && g2.getVisibility()==View.VISIBLE))
        {
            Toast.makeText(PlayActivity.this,"Wolf would eat Goat",Toast.LENGTH_LONG).show();
            return false;
        }
        else if((f1.getVisibility()!=View.VISIBLE && g1.getVisibility()==View.VISIBLE && c1.getVisibility()==View.VISIBLE) || (f2.getVisibility()!=View.VISIBLE && g2.getVisibility()==View.VISIBLE && c2.getVisibility()==View.VISIBLE))
        {
            Toast.makeText(PlayActivity.this,"Goat would eat Cabbage",Toast.LENGTH_LONG).show();
            return false;
        }

        else {
            return true;
        }



    }
    void alertbox() {
        long endTime = SystemClock.elapsedRealtime();
        long totalTime = endTime - startTime;

        alert = new AlertDialog.Builder(PlayActivity.this);
        alert.setTitle("Congratulations!! completed puzzle successfully");
        alert.setMessage("Stats:\n" +
                "Time: " + totalTime + " milliseconds\n" +
                "Solution Length: " + solutionLength + "\n" +
                "Number of Queue Ops: " + numberOfQueueOps + "\n" +
                "Max Queue Size: " + maxQueueSize + "\n" +
                "Do you want to play again?");
        alert.setCancelable(false);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetGame();
                dialogInterface.cancel();
            }
        });
        alert.create().show();
    }
}
