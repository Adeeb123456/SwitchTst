package com.geniteam.switchtst;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SwitchActivity2 extends AppCompatActivity implements View.OnTouchListener{
ImageView imageViewSwitch;

  //  int[] images=new int[]{R.drawable.switch5,R.drawable.switch4,R.drawable.switch3,R.drawable.switch2,R.drawable.switch1};
  //  int[] imageWithShades=new int[]{R.drawable.switch5with_shd,R.drawable.switch4with_shd,R.drawable.switch3with_shd, R.drawable.switch2with_shd,R.drawable.switch1with_shd};
   // int[] imageWithOutShades=new int[]{R.drawable.switch5with_out_shd,R.drawable.switch4with_out_shd,R.drawable.switch3with_out_shd, R.drawable.switch2with_out_shd,R.drawable.switch1with_out_shd};


   int[] imageWithShadesR=new int[]{R.drawable.switch1with_out_shd_r,R.drawable.switch1with_out_shd_r,R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r,R.drawable.switch1with_out_shd_r};
    int[] imageWithOutShadesR=new int[]{R.drawable.switch1with_out_shd_r,R.drawable.switch1with_out_shd_r,R.drawable.switch1with_out_shd_r, R.drawable.switch1with_out_shd_r,R.drawable.switch1with_out_shd_r};


    int[] imageWithShades=new int[]{R.drawable.switch1with_out_shd,R.drawable.switch1with_out_shd,R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd,R.drawable.switch1with_out_shd};
    int[] imageWithOutShades=new int[]{R.drawable.switch1with_out_shd,R.drawable.switch1with_out_shd,R.drawable.switch1with_out_shd, R.drawable.switch1with_out_shd,R.drawable.switch1with_out_shd};

    int lastState=1;
    int currentState=1;
    int stateCount=1;
    int currentRule;
    TextView textViewState;
    TextView descripSwitchTv;
    TextView titleSwitchTv;
    RelativeLayout progressBar;

    String accesstokenTest="Bearer 2875ddf0a944aee706516a495dd08727cefc6812";
    private GestureDetector mGestureDetector;
    private double mCurrAngle = 0;
    private double mPrevAngle = 0;

    Animation animation ;
    float xc;
    float yc;
    int currentRoundAngle;
    int currentImageNumber=4;
    double stateAngle=0;
    int stateAngleImage=0;
    double currentAngleActionUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
try{





         imageViewSwitch=(ImageView)findViewById(R.id.imageViewSwitch);
         textViewState=(TextView)findViewById(R.id.textViewState);
         descripSwitchTv=(TextView)findViewById(R.id.descripSwitchTv);
         titleSwitchTv=(TextView)findViewById(R.id.titleSwitchTv);
         progressBar=(RelativeLayout)findViewById(R.id.progressBarContainer) ;
         imageViewSwitch.setOnTouchListener(this);

         imageViewSwitch.setRotation(180);


     //     Utils.setFont(getApplicationContext(),titleSwitchTv);
          //Utils.setFont(getApplicationContext(),descripSwitchTv);


    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
try {
    /*
               showProgressBar();
            if(AppPref.getQR_AccessTokenPref()!=null){
                String accessToken= ApiConstants.BEARER+" "+AppPref.getQR_AccessTokenPref().getAccessToken();
                GetCurrentAccountRule(accesstokenWithBreaer());
            }else {
               hideProgressBar();
               show_QR_Auth_ErrorDialogue();
            }
*/
            //testing
   // GetCurrentAccountRule(accesstokenTest);


}catch (Exception e){
    e.printStackTrace();
}

        }
    },20);

}catch (Exception e){
    e.printStackTrace();
}
    }




public void setCurrentSwitchAngle(int state){
    if(state==1){
        stateAngle=0;
        stateAngleImage=4;
        animate(0,0,500);
        setSwitchBgWithOutShade(4);
    }else if(state==2){
        stateAngle=72;
        stateAngleImage=3;
        animate(0,54,500);
        setSwitchBgWithOutShade(3);
    }else if(state==3){
        stateAngle=108;
        stateAngleImage=2;
        animate(0,90,500);
        setSwitchBgWithOutShade(2);
    }else if(state==4){
        stateAngle=144;
        stateAngleImage=1;
        animate(0,126,500);
        setSwitchBgWithOutShade(1);
    }else if(state==5){
        stateAngle=180;
        stateAngleImage=0;
        animate(0,180,500);
        setSwitchBgWithOutShade(0);
    }
}


















    public void showProgressBar(){
    progressBar.setVisibility(View.VISIBLE);
}

    public void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }


float lastX;
    float lastY;
 float x ;
float y ;

    boolean swipeBotToTop;
    boolean swipeTopToBot;
    boolean swipeLeftToRight;
    boolean swipeRightToLeft;
    boolean isReachTop180=false;
    boolean isReachBot0=false;
    double newAngleReverse;
    boolean runLogic1=true;
    boolean runLogic2=true;
    @Override
    public boolean onTouch(final View v, MotionEvent event) {
        xc = v.getWidth() / 2;
        yc = v.getHeight() / 2;
        Log.i("debug6","img  x"+xc);
        Log.i("debug6","img center y"+yc);

        Log.i("debug5","on touch x "+x);
        Log.i("debug5","touch y "+y);


        setSwitchBgWithShade(currentImageNumber);


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                x = event.getX();
                y = event.getY();
                //  wheel.clearAnimation();
             //
                  mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));

                mPrevAngle=mCurrAngle;
                Log.i("debug5","action down previous angle "+mPrevAngle);
                Log.i("debug5","action up current angle "+mCurrAngle);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                lastX=x;
                lastY=y;
                x = event.getX();
                y = event.getY();


                mPrevAngle=mCurrAngle;

                        mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));

                        if (mCurrAngle < 0) {

                            Log.d("debug13", " else less than angle " + mCurrAngle);

                   if(mPrevAngle>0&&mCurrAngle<0){
                    isReachTop180 = true;
                      }else
                 if (mPrevAngle >mCurrAngle) {
                                isReachTop180 = true;

                            } else {





                                mCurrAngle = mCurrAngle + 180;

                                if(mCurrAngle>0&&mCurrAngle<135){
                                    isReachTop180=true;
                                }else {
                                    isReachTop180=false;
                                }


                               // if(mCurrAngle>)

                            }

                            newAngleReverse = mCurrAngle + 180;

                            Log.d("debug13", " else less than angle +180 " + mCurrAngle);

                            //  mCurrAngle=mCurrAngle-180;

                         mPrevAngle = mCurrAngle;
                        }else {
                            isReachTop180 = false;
                            isReachBot0=false;
                            if(mCurrAngle==0){
                                isReachBot0=true;
                            }
                        }


                        Log.d("debug14", " curr angle " + mCurrAngle);




                        if (mCurrAngle > 0 && mCurrAngle <= 180&&!isReachTop180) {
                            animate(mPrevAngle, mCurrAngle, 0);

                        }
                break;
            }
            case MotionEvent.ACTION_UP : {
                isReachTop180=false;
              // mPrevAngle =mCurrAngle ;
                currentAngleActionUp = Math.toDegrees(Math.atan2(x - xc, yc - y));


                if(currentAngleActionUp<0){
                    Log.d("debug9","less than angle up"+currentAngleActionUp);
                    if(currentAngleActionUp<0){
                        currentAngleActionUp=currentAngleActionUp+180;
                        Log.d("debug9","less than angle +180 up"+currentAngleActionUp);
                    }else {
                        mCurrAngle=180;
                    }

                }
               Log.d("debug4"," action up");
                Log.i("debug5","action up previous angle "+mPrevAngle);
                Log.i("debug5","action up current angle "+mCurrAngle);
            if(currentAngleActionUp>=0&&currentAngleActionUp<=180) {

                    if (currentRoundAngle == 36) {
                        callApiWithEndpoint(1);
                        animate(currentAngleActionUp, 0, 500);
                        setSwitchBgWithOutShade(4);
                        currentImageNumber = 4;
                    } else if (currentRoundAngle == 72) {
                        //   animate(72,72,400);
                        animate(currentAngleActionUp, 54, 500);

                        callApiWithEndpoint(2);
                        setSwitchBgWithOutShade(3);
                        currentImageNumber = 3;
                    } else if (currentRoundAngle == 108) {
                        // animate(108,108,400);
                        animate(currentAngleActionUp, 90, 500);
                        callApiWithEndpoint(3);
                        setSwitchBgWithOutShade(2);
                        currentImageNumber = 2;
                    } else if (currentRoundAngle == 144) {
                        //animate(144,144,400);
                        animate(currentAngleActionUp, 136, 500);
                        callApiWithEndpoint(4);

                        currentImageNumber = 1;
                        setSwitchBgWithOutShade(1);
                    } else if (currentRoundAngle == 180) {
                        animate(currentAngleActionUp, 180, 500);
                        callApiWithEndpoint(5);

                        currentImageNumber = 0;
                        setSwitchBgWithOutShade(0);
                    } else {
                        setSwitchBgWithOutShade(currentImageNumber);
                    }
                }
            else {
               // imageViewSwitch.setRotation((float) mCurrAngle);
               // animate(mPrevAngle, mCurrAngle, 0);
            }
                break;
            }
        }
        return true;
    }


    public void setSwitchBgWithOutShade(final int i){
      new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        imageViewSwitch.setImageResource(imageWithOutShades[i]);
    }
},600);

    }


    public void setSwitchBgWithShade(final int i){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageViewSwitch.setImageResource(imageWithShades[i]);
            }
        },20);

    }

    public void callApiWithEndpoint(final int endPoint){
               Log.d("debug4","call api");

    }



         private void animate(double fromDegrees, double toDegrees, long durationMillis) {
                final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                rotate.setDuration(durationMillis);
                rotate.setFillEnabled(true);
                rotate.setFillAfter(true);
                imageViewSwitch.startAnimation(rotate);


                System.out.println(mCurrAngle);
    }


     public void fadeIn(TextView textView){
    }








    public void calculateCurrentMidAngle(double mCurrAngle){
        double mid=mCurrAngle/2;
        if(mid>=18&&mid<36){
animate(0,0,0);
        }

        if(mid<18&&mid<36){
            animate(mCurrAngle,36,0);
        }

    }
}