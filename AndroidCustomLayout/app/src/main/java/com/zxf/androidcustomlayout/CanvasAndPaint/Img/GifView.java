package com.zxf.androidcustomlayout.CanvasAndPaint.Img;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class GifView extends View {
    private static final String TAG = GifView.class.getSimpleName();
    private Movie mMovie;
    private long mPlayMovieTime;
    private String DOWNLOAD_ADDR = "";
    private Context context;
    private int mViewWidth;
    private int mViewHeight;
    private boolean isPlaying;

    public GifView(Context context) {
        super(context);
        this.context = context;
        readGifFormNet();
    }

    public GifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }
    /**
     * 设置gif图片的url，开始播放gif
     * @param url
     */
    public void setUrl(String url) {
        DOWNLOAD_ADDR = url;
        //先从本地读取，如果本地没有，在从网络上获取
        mMovie = readGifFormLoacl();
        if (mMovie == null) {
            //先下载只本地
            gifDownload();
            readGifFormNet();
        }
    }
    /**
     * 从资源文件中读取gif图片
     */
    public void readGifFormNative() {
        InputStream in=null;
        try {
            in = context.getAssets().open("wu.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMovie = Movie.decodeStream(in);
    }

    /**
     * 加载本地图片
     */
    public Movie readGifFormLoacl() {
        try {
            File dir = context.getExternalCacheDir().getAbsoluteFile();
            String fileName = DOWNLOAD_ADDR.substring(
                    DOWNLOAD_ADDR.lastIndexOf("/"), DOWNLOAD_ADDR.length());
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, fileName);
            return mMovie = Movie.decodeFile(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载网络图片
     */
    private void readGifFormNet() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    URL url = new URL(DOWNLOAD_ADDR);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    // connection.setRequestMethod("GET");
                    int size = connection.getContentLength();
                    Log.e(TAG, "size = " + size);
                    InputStream in = connection.getInputStream();
                    byte[] array = streamToBytes(in);
                    mMovie = Movie.decodeByteArray(array, 0, array.length);
                    // 得到图片宽高
                    if (mMovie != null) {
                        mViewWidth = mMovie.width();
                        mViewHeight = mMovie.height();
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void result) {
                mHandler.sendEmptyMessage(0);
            }

        }.execute();
    }

    public void setPlaying(boolean flag) {
        isPlaying = flag;
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    invalidate();
                    break;

                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    /**
     * 下载网络图片到本地
     */
    public void gifDownload() {
        new Thread() {
            public void run() {
                InputStream in = null;
                FileOutputStream fos = null;
                try {
                    URL url = new URL(DOWNLOAD_ADDR);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    int size = connection.getContentLength();
                    Log.e(TAG, "size = " + size);
                    in = connection.getInputStream();
                    File dir = context.getExternalCacheDir().getAbsoluteFile();
                    String fileName = DOWNLOAD_ADDR.substring(
                            DOWNLOAD_ADDR.lastIndexOf("/"),
                            DOWNLOAD_ADDR.length());
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    File file = new File(dir, fileName);
                    Log.d("info", "file->" + file.getAbsolutePath());
                    fos = new FileOutputStream(file);
                    int len = -1;
                    byte[] buffer = new byte[1024 * 8];
                    while ((len = in.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                        fos.flush();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fos != null) {
                            fos.close();
                        }
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
        }.start();

    }
    /**
     * 下载网络图片
     */
    private void httpTest() {
        try {
            URL url = new URL(DOWNLOAD_ADDR);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            // connection.setRequestMethod("GET");
            int size = connection.getContentLength();
            Log.e(TAG, "size = " + size);
            InputStream in = connection.getInputStream();
            byte[] array = streamToBytes(in);
            mMovie = Movie.decodeByteArray(array, 0, array.length);
            // 得到图片宽高
            if (mMovie != null) {
                mViewWidth = mMovie.width();
                mViewHeight = mMovie.height();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] streamToBytes(InputStream is) {
        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
        byte[] buffer = new byte[1024];
        int len;
        try {
            while ((len = is.read(buffer)) >= 0) {
                os.write(buffer, 0, len);
            }
        } catch (java.io.IOException e) {
        }
        return os.toByteArray();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setAntiAlias(true);
        setLayerType(LAYER_TYPE_SOFTWARE, p);
        //获取屏幕宽高，将gif图片宽或高铺满屏幕
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        if (mMovie != null) {
            mViewWidth = mMovie.width();
            mViewHeight = mMovie.height();
            float x = 0;
            float y = 0;
            //float width = getWidth();
            //float height = getHeight();
            float width = metrics.widthPixels;
            float height = metrics.heightPixels;
            float saclex = (float) width / (float) mViewWidth;
            float sacley = (float) height / (float) mViewHeight;
            float sameRate = saclex > sacley ? sacley : saclex;
            canvas.scale(sameRate, sameRate);
            x = ((width - mViewWidth * sameRate) / 2) / (metrics.density);
            y = ((height - mViewHeight * sameRate) / 2) / (sameRate);
            if (isPlaying) {

                long now = android.os.SystemClock.uptimeMillis();
                if (mPlayMovieTime == 0) { // first time
                    mPlayMovieTime = now;
                }
                int dur = mMovie.duration();
                if (dur == 0) {
                    dur = 1000;
                }
                int relTime = (int) ((now - mPlayMovieTime) % dur);
                mMovie.setTime(relTime);
                mMovie.draw(canvas, x, y);
                // if ((now - mPlayMovieTime) > dur) {
                // mPlayMovieTime = 0;
                // isPlaying = false;
                // }
            } else {
                mMovie.setTime(0);
                mMovie.draw(canvas, x, y);
            }
            invalidate();
        }
    }
}
