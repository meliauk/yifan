/*
 Navicat Premium Data Transfer

 Source Server         : 1212
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : home

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 31/01/2020 21:12:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad`  (
  `ad_id` int(11) NOT NULL AUTO_INCREMENT,
  `ad_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `ad_url` varchar(512) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `ad_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `ad_gmt_start` datetime(0) NULL DEFAULT NULL COMMENT '广告开始时间',
  `ad_gmt_end` datetime(0) NULL DEFAULT NULL COMMENT '广告结束时间',
  `ad_gmt_create` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `ad_pos` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '位置',
  `ad_status` int(5) NULL DEFAULT NULL COMMENT '广告状态',
  PRIMARY KEY (`ad_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ad
-- ----------------------------
INSERT INTO `ad` VALUES (1, 'ad title', 'www.xxx.xxxx.cn', NULL, '2020-01-06 00:00:00', '2020-01-13 02:00:00', '2020-01-13 12:22:16', 'nav', 1);
INSERT INTO `ad` VALUES (2, 'd123da12', 'www.11111xxx.cn', NULL, '2021-01-12 00:00:00', '2020-01-25 01:00:00', '2020-01-13 12:25:26', 'nav', 1);

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `blog_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT 'blog id',
  `blog_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'blog 标题',
  `blog_desc` longtext CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'blog 描述',
  `blog_content` longtext CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'blog 内容',
  `blog_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '作者',
  `blog_cover_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文章封面(我和她)',
  `blog_time` datetime(0) NULL DEFAULT NULL COMMENT 'blog 时间',
  `blog_read` bigint(255) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT 'blog 阅读量',
  `blog_comm` bigint(255) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT 'blog 评论数',
  `blog_like` bigint(255) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT 'blog 喜欢数',
  `blog_type` int(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT 'blog 类型',
  `blog_publish_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文章类型(Java,js..)',
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, '第一个blog', '描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客客文章描章描文章描客客章描文章描客客文章描文章描文章描客客文章描文文章描文章描文章描文章描客客文章描文章描客客文章描文章描文章描客客文章描文文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描', '```\r\nreturn \"redirect:/product/toList\";\r\n```', 'rui', NULL, '2019-12-29 14:24:14', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 2, 'java');
INSERT INTO `blog` VALUES (2, '这是测试标题2', '描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客客文章描章描文章描客客章描文章描客客文章描文章描文章描客客文章描文文章描文章描文章描文章描客客文章描文章描客客文章描文章描文章描客客文章描文文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描文章描客文章描文章描文章描', '```\r\nredirect:/admin/\r\n```', 'rui', NULL, '2020-01-02 17:22:17', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 2, 'java');
INSERT INTO `blog` VALUES (3, '这是测试标题3', '这是测试描述...这是测试描述...这是测试描述...这是测试描述...这是测试描述...这是测试描述...这是测试描述...', '```\r\nreturn \"redirect:/product/toList\";\r\n```', 'yifan', NULL, '2020-01-02 17:22:17', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 1, 'java');
INSERT INTO `blog` VALUES (4, '标题4', '描述', '### 关于 Editor.md\n- 如何整合他们?\n', 'yifan', NULL, '2020-01-02 17:22:17', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 1, 'java');
INSERT INTO `blog` VALUES (5, '标题5', '描述', '### 关于 Editor.md\n- 如何整合他们?\n\n```\n<link rel=\"stylesheet\" href=\"<%= BASE_URL %>editormd.preview.css\">\n<script src=\"<%= BASE_URL %>jquery.min.js\"></script>\n<script src=\"<%= BASE_URL %>editormd.min.js\"></script>\n<script src=\"<%= BASE_URL %>marked.min.js\"></script>\n<script src=\"<%= BASE_URL %>prettify.min.js\"></script>\n```\n在 publish 中 导入他们 \n然后直接使用即可\n\n```\nthis.$nextTick(()=>{\n	console.log(\"详细信息....\")\n	let editorView = editormd.markdownToHTML(\"blog-view\", {\n		htmlDecode      : \"style,script,iframe\",\n		emoji           : true,\n		taskList        : true,\n		tex             : true,  // 默认不解析\n		flowChart       : true,  // 默认不解析\n		sequenceDiagram : true,  // 默认不解析\n	});\n})\n```\n\n- 完美解决 问题', 'yifan', NULL, '2020-01-02 17:22:17', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 1, 'java');
INSERT INTO `blog` VALUES (6, 'shiro使用6', '123123', '### 关于 Editor.md', 'yifan', NULL, '2020-01-02 17:22:17', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 1, 'perl');
INSERT INTO `blog` VALUES (7, 'mybatis-plus-7', '123123', '### 关于 Editor.md', 'yifan', NULL, '2020-01-02 17:22:17', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 1, 'perl');
INSERT INTO `blog` VALUES (8, 'e\'q\'we', 'QWE', '### 关于 Editor.md', 'yifan', NULL, '2020-01-02 17:22:17', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 1, 'java');
INSERT INTO `blog` VALUES (9, 'addaddssddddd', 'this is sa ', '### 关于 Editor.md', 'yifan', NULL, '2020-01-02 17:22:17', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 1, 'c');
INSERT INTO `blog` VALUES (10, '我的测试123', '我的测试123我的测试123我的测试123我的测试123我的测试123我的测试123我的测试123我的测试123', ':mask:\r\n\r\n\r\n```\r\ndadawdawawda  表情\r\n```', 'rui', NULL, '2020-01-02 17:22:17', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 2, 'java');
INSERT INTO `blog` VALUES (11, 'sptingboot 整合?sptingboot 整合?sptingboot 整合?sptingboot 整合?sptingboot 整合?sptingboot 整合?sptingboot 整合?sptingboot 整合?', '怎么使用........怎么使用........怎么使用........', '### 关于 Hello world', 'rui', NULL, '2020-01-03 09:49:43', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 2, 'java');
INSERT INTO `blog` VALUES (12, 'hahahahaah', 'xxxxxxxxxx', '```\r\n@RestController\r\npublic class BlogController {\r\n\r\n    @Autowired\r\n    private BlogService blogService;\r\n\r\n    @GetMapping(\"/yifan/blogs\")\r\n    public List getBlogs(){\r\n        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();\r\n\r\n        List<Blog> blogList = blogService.list(null);\r\n//        blogList.forEach(System.err::print);\r\n        return blogList;\r\n    }\r\n\r\n}\r\n\r\n```', '弋凡', NULL, '2020-01-03 11:49:11', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 1, 'java');
INSERT INTO `blog` VALUES (13, 'eritor.md 上传图片', '怎么使用 ,怎么上传,原理是什么?', '![](http://localhost:8081/images/ok.jpg)### 关于 Editor.md:innocent:&hearts;:stuck_out_tongue_winking_eye: :smiling_imp:\r\n\r\n```java\r\nJSONObject jsonObject = new JSONObject();\r\n\r\n JSONObject jsonObject = new JSONObject();\r\n        ResultInfo resultInfo = articleService.saveImage(file,request);\r\n        if (resultInfo.getResultCode()==0){\r\n            jsonObject.put(\"success\", 0);//图片上传失败的信息码\r\n            jsonObject.put(\"message\", \"upload error!\");//信息\r\n        }\r\n        else {\r\n            jsonObject.put(\"url\", resultInfo.getResultObj());//图片回显地址，即文件存放地址，应为虚拟路径\r\n            jsonObject.put(\"success\", 1);//图片上传成功的信息码\r\n            jsonObject.put(\"message\", \"upload success!\");//信息\r\n        }\r\n```', 'yifan', NULL, '2020-01-06 15:10:23', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 1, 'java');
INSERT INTO `blog` VALUES (14, '我们的故事..', '一个小小的故事...嗒嗒嗒', '### 关于 小故事\r\n- 第一话\r\n	xxxxxx\r\n	xxxxxxxx\r\n- 第二话\r\n	yyyyyyyyyyy', 'rui', '', '2020-01-06 16:26:55', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 2, '我们故事');
INSERT INTO `blog` VALUES (15, 'gus----===', 'dexcccc', '### 关于 Editor.md', 'rui', 'icon.png', '2020-01-06 17:58:28', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 2, '我们故事');
INSERT INTO `blog` VALUES (16, 'dasd', 'dawdwadad', '### 关于 Editor.mdddd', 'rui', 'dev.png', '2020-01-06 18:08:57', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 2, '我们故事');
INSERT INTO `blog` VALUES (17, 'ddad', 'wdwaddwa', '### 关于 Editor.md', 'rui', '123.png', '2020-01-06 18:12:33', 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000, 2, '我们故事');

-- ----------------------------
-- Table structure for blog_type
-- ----------------------------
DROP TABLE IF EXISTS `blog_type`;
CREATE TABLE `blog_type`  (
  `id` int(255) NOT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文章类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_type
-- ----------------------------
INSERT INTO `blog_type` VALUES (1, '博客文章');
INSERT INTO `blog_type` VALUES (2, '我们故事');

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `friend_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `friend_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '友链名称',
  `friend_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '友链描述',
  `friend_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '友链地址',
  `friend_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '友链图标',
  `friend_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`friend_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES (1, 'via导航', '贵在精而不多', 'https://www.viacl.com//', NULL, '2020-01-03 11:23:43');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int(255) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `u_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `u_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `u_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '个人描述',
  `u_power` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户权限',
  `u_state` int(5) NULL DEFAULT NULL COMMENT '1 在线  - 2 离线',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'yifan', '123', '2050781802@qq.com', '这就是我', 'user:publish,user:our', 1);
INSERT INTO `user` VALUES (2, 'rui', '123', '2xxxxx3@qq.com', '你就是你', 'user:our', 1);
INSERT INTO `user` VALUES (3, '123', '123', 'xxx@qq.com', '213 是 213', 'user:our', 1);

SET FOREIGN_KEY_CHECKS = 1;