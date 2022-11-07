
CREATE DATABASE blog;

USE `blog`;
SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE b_admin (	   -- 用户表
 a_id INT(5) NOT NULL AUTO_INCREMENT,	-- 用户ID
 a_name VARCHAR(20) NOT NULL UNIQUE ,   -- 用户名
 a_nichen VARCHAR(15) DEFAULT NULL,     -- 用户昵称
 a_data DATETIME DEFAULT CURRENT_TIMESTAMP,	-- 创建日期
 a_sex CHAR(1) DEFAULT '男',	-- 性别
 a_pwd VARCHAR(8) NOT NULL,	-- 登录密码 
 PRIMARY KEY(a_id)	-- 主键 用户ID
);

INSERT INTO b_admin		-- ID可以省去，自增
VALUES(1,'apple','虹猫','2022-06-15','男','123456'),
      (2,'bnana','蓝兔','2022-06-15','女','654321'),
      (3,'QWER','大奔','2022-06-18','男','12345678'),
      (4,'黑小虎','小虎','2022-06-19','男','654321');




CREATE TABLE article (
 article_id INT (5) NOT NULL AUTO_INCREMENT  COMMENT'文章ID',  
 article_author_id INT (5) COMMENT '文章作者ID',
 article_type VARCHAR (20) DEFAULT '通文'  COMMENT '类别',
 article_title VARCHAR (20) NOT NULL  COMMENT'文章标题',
 article_content MEDIUMTEXT NOT NULL COMMENT '文章内容',
 article_limit VARCHAR (20) DEFAULT '公开' COMMENT '权限',
 article_date DATETIME DEFAULT CURRENT_TIMESTAMP  COMMENT '发布日期',
 PRIMARY KEY (article_id),
 FOREIGN KEY (article_author_id) REFERENCES  b_admin (a_id)
);

 SELECT * FROM article;
 
 
INSERT INTO article(`article_author_id`,`article_type`,`article_title`,`article_content`,`article_limit`)	
  VALUES
	(1,'通文','三国说','曹操邀请刘备在一起喝用青梅煮的酒。
席间曹操问刘备：“天下谁可称为英雄。”刘备想了下回答：“河北袁绍。”
曹操立即笑而否决。刘备想了想说：“淮南袁术。”
又被曹操否决了。接着刘备把凡是有点名气的诸侯都说了一遍，可惜没有一个人得到了曹操的认同。
刘备只好跟曹操说不知道谁可称英雄。没想到曹操大笑，指着刘备说：“天下的英雄只有两个人，就是我和你。”
刘备心里一颤，面露惊色，怕曹操起了杀心。恰逢天上一声惊雷，刘备的筷子掉在了地上。
曹操以为刘备是被雷声吓到了，才会面露惊色，没想到一个大男人还会害怕打雷。于是就问刘备：“你还怕雷。”
刘备仿佛被吓的够呛，实际暗自庆幸这个雷才让自己没露破绽。回答：“雷声这么想咋能不怕呢。”
曹操这才对刘备放松了警惕，而刘备也因此暂时逃过了曹操的威胁，这就是青梅煮酒。','公开'),
	(2,'言情','相遇','　在一个非常宁静而美丽的小城，有一对非常恩爱的恋人，他们每天都去海边看日出，晚上去海边送夕阳，每个见过他们的人都向他们投来羡慕的目光。　　上帝约定的三年期限很快就要到了。就在最后一天，蜻蜓昔日的恋人跟那个男医生举行了婚礼。　　蜻蜓悄悄地飞进教堂，落在上帝的肩膀上，他听到下面的恋人对上帝发誓说：我愿意！他看着那个男医生把戒指戴到昔日恋人的手上，然后看着他们甜蜜地亲吻着。蜻蜓流下了伤心的泪水。　　上帝叹息着：“你后悔了吗？”蜻蜓擦干了眼泪：“没有！”上帝又带着一丝愉悦说：“那么，明天你就可以变回你自己了。”蜻蜓摇了摇头：“就让我做一辈子蜻蜓吧……”　　有些缘分是注定要失去的，有些缘分是永远不会有好结果的。爱一个人不一定要拥有，但拥有一个人就一定要好好去爱他。你的肩上有蜻蜓吗？','公开'),
	(3,'悬疑','钢铁之躯','　花开的季节，与寂寞有染，于尘世无缘。灿如朝日的年纪，轻轻的挥洒如兰的诗词，看少年的心开成陌上的蔷薇，在这泛滥的雨季，兀自摇曳，兀自妖娆。','公开'),
	(3,'通文','不死之身','我深爱着我的文字，有人也深爱着我，我不寂寞，只是偶尔会感到孤单。一个人的时候，望着天空，手里握着竹笔，也许就能找到内心的答案。','公开'),
	(4,'通文','老人与海','　幸福是生命追求的最高层次，幸福是人生最大的酬报，幸福是每一个人来过世界之后对生活的感恩，幸福又是你对身边的重新认识和重新体验。','公开');

