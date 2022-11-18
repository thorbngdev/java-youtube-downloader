package com.github.kiulian.downloader;

import com.github.kiulian.downloader.downloader.request.RequestVideoInfo;
import com.github.kiulian.downloader.downloader.response.Response;
import com.github.kiulian.downloader.model.videos.VideoInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing downloading clips")
class YoutubeDownloadClip_Tests {

    private YoutubeDownloader downloader;

    @BeforeEach
    void initDownloader() {
        downloader = new YoutubeDownloader();
    }

    @Test
    @DisplayName("Clip test")
    public void test1() {
        String expectedId = "UgkxCHYY91BZEGGReg437HyRzE5vfHrJgagA";
        String sourceId = "sEDDfohAbU4";
        RequestVideoInfo request = new RequestVideoInfo(expectedId);
        Response<VideoInfo> response = downloader.getVideoInfo(request);
        VideoInfo videoInfo = response.data();
        assertEquals(sourceId, videoInfo.details().videoId(), "Clip checked");
    }

    @Test
    @DisplayName("Normal test")
    public void test2() {
        String expectedId = "fuqIIstqI5I";

        RequestVideoInfo request = new RequestVideoInfo(expectedId);
        Response<VideoInfo> response = downloader.getVideoInfo(request);
        VideoInfo videoInfo = response.data();
        assertEquals(expectedId, videoInfo.details().videoId(), "Normal Video checked");
    }
}
