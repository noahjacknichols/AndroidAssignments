package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.transition.ChangeTransform;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class chatWindow extends AppCompatActivity {
    ListView chatView;
    EditText chatText;
    Button sendButton;
    ArrayList<String> chatMessages;
    ChatAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        chatView = findViewById(R.id.chatView);
        chatText = findViewById(R.id.chatText);
        sendButton = findViewById(R.id.sendButton);
        chatMessages = new ArrayList<>();
        messageAdapter = new ChatAdapter(this);
        chatView.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String x = chatText.getText().toString();

                chatMessages.add(x);
                messageAdapter.notifyDataSetChanged();
                chatText.setText("");

            }
        });


    }

    @Override
    protected void onStart(){

        super.onStart();
    }

    @Override
    protected void onResume(){


        super.onResume();
    }

    @Override
    protected void onPause(){

        super.onPause();
    }

    @Override
    protected void onStop(){

        super.onStop();
    }

    @Override
    protected void onDestroy(){

        super.onDestroy();
    }

    private class ChatAdapter extends ArrayAdapter<String>{
        public ChatAdapter(Context ctx){
            super(ctx, 0);
        }
        public int getCount(){
            return chatMessages.size();
        }
        public String getItem(int position){
            return chatMessages.get(position);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = chatWindow.this.getLayoutInflater();

            View result = null;
            if(position % 2 == 0){
                result = inflater.inflate(R.layout.chat_row_incoming, null);

            }else{
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }
            TextView message = (TextView) result.findViewById(R.id.message_text);
            message.setText(getItem(position));
            return result;

        }

    }
}
