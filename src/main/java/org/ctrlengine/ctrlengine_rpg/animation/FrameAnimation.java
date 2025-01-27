package org.ctrlengine.ctrlengine_rpg.animation;

import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Ctrlengine Development Team
 */
public class FrameAnimation extends Thread{
    private volatile boolean running = true;
    // 定义帧动画的帧列表
    private ArrayList<Image> frames;
    // 定义帧动画的当前帧索引
    private int currentFrameIndex;
    // 定义帧动画的计时器
    private Timer timer;
    // 定义帧动画的计时器任务
    private TimerTask task;
    // 定义帧动画的帧率
    private int frameRate;
    @Override
    public void run() {
        while (running) {
            // 初始化帧动画的当前帧索引
            currentFrameIndex = 0;
            // 创建帧动画的计时器
            timer = new Timer();
            // 定义帧动画的计时器任务
            task = new TimerTask() {
                @Override
                public void run() {
                    // 更新帧动画的当前帧索引
                    currentFrameIndex++;
                    // 如果当前帧索引超出帧列表的大小，则重置为0
                    if (currentFrameIndex >= frames.size()) {
                        currentFrameIndex = 0;
                    }
                }
            };
            // 安排帧动画的计时器任务按照帧率执行
            timer.scheduleAtFixedRate(task, 0, 1000 / frameRate);
        }
    }
    public void stopAnimation() {
        running = false;
        timer.cancel();
    }
    public void setFrames(ArrayList<Image> frames, String imagePath, String name) {
        // 清除原有的帧列表
        this.frames.clear();
        // 设置新的帧列表
        this.frames.addAll(frames);
        // 如果传入的图像路径和名称不为空，则加载新的帧到帧列表中
        if (imagePath != null && !imagePath.isEmpty() && name != null && !name.isEmpty()) {
            // 假设loadFramesFromImage是一个从图像中加载帧的方法
            ArrayList<Image> newFrames = loadFramesFromImage(imagePath, name);
            // 将新加载的帧添加到帧列表中
            this.frames.addAll(newFrames);
        }
    }

    private ArrayList<Image> loadFramesFromImage(String imagePath, String name) {
        ArrayList<Image> loadedFrames = new ArrayList<>();
        Image spriteSheet = Toolkit.getDefaultToolkit().getImage(imagePath);
        int frameWidth = 64;
        int frameHeight = 64;
        int spriteSheetWidth = spriteSheet.getWidth(null);
        int spriteSheetHeight = spriteSheet.getHeight(null);
        int rows = spriteSheetHeight / frameHeight;
        int columns = spriteSheetWidth / frameWidth;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Image frame = Toolkit.getDefaultToolkit().createImage(
                                new FilteredImageSource(spriteSheet.getSource(),
                                new CropImageFilter(j * frameWidth, i * frameHeight, frameWidth, frameHeight))
                );
                loadedFrames.add(frame);
            }
        }
        return loadedFrames;
    }
}
