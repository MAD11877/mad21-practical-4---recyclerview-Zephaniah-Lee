package sg.edu.np.s10205164;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    Context context;
    ArrayList<User> data;

    public UserAdapter(Context c, ArrayList<User> d)
    {
        context = c;
        data = d;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = null;
        if(viewType == 0) //multiplies of three
        {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user_alt, parent, false);
        }
        else
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user, parent, false);

        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        Log.d("RV","onBindViewHolder #" + position);
        User u = data.get(position);
        holder.name.setText(u.getName());
        holder.description.setText(u.getDescription());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Profile");
                builder.setMessage(u.getName());
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){

                    public void onClick(DialogInterface dialog, int id){
                        Intent in = new Intent(context, MainActivity.class);
                        in.putExtra("userName", u.getName());
                        in.putExtra("userDescription", u.getDescription());
                        in.putExtra("userId", u.getId());
                        in.putExtra("userFollowed", u.isFollowed());
                        context.startActivity(in);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        String s = data.get(position).getName();

        if(s.substring(s.length() - 1).equals("7"))
            return 0;
        return 1;
    }

}
