package com.lizza.base.oval;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.oval.constraint.AssertValid;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhraseEditParam {

    private Long id;

    private Long groupId;

    private List<Long> keywordIds;

    @NotNull
    @NotEmpty
    private String type;

    @NotNull
    @AssertValid
    private Content content;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Content {

        @NotNull(when = "groovy:type == 'TEXT'")
        @Size(max = 500)
        private String text;

        @NotNull(when = "groovy:_this.type == 'IMAGE'")
        private List<Image> images;

        @NotNull(when = "groovy:_this.type == 'VIDEO'")
        private Video video;

        @NotEmpty(when = "groovy:_this.type == 'FILE'")
        private File file;

        @NotEmpty(when = "groovy:_this.type == 'NEWS'")
        private News news;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Image {

        @NotEmpty
        private String ossKey;

        @NotEmpty
        private String url;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Video {

        @NotEmpty
        private String ossKey;

        @NotEmpty
        private String title;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class File {

        @NotEmpty
        private String ossKey;

        @NotEmpty
        private String title;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class News {

        @NotEmpty
        private String link;

        @Size(max = 100)
        private String title;

        private String desc;

        private String imgUrlOssKey;

        private String url;
    }
}
