package hoanglong.framgia.com.mvpandroid;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class MvpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(getApplicationContext())
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this, imagePipelineConfig);
        Fresco.getImagePipeline().clearDiskCaches();
        Fresco.getImagePipeline().clearCaches();
    }
}
