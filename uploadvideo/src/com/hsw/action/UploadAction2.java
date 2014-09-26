package com.hsw.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hsw.entity.UserEntity;
import com.hsw.entity.VideoEntity;
import com.hsw.util.MyBatisUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UploadAction2 extends ActionSupport {
	private String videoname;
	private String videodesp;
	private String uploaduser;
	
	// 封装上传文件域的属性
    private File video;
    // 封装上传文件类型的属性
    private String videoContentType;
    // 封装上传文件名的属性
    private String videoFileName;

    @Override
    public String execute() {
    	System.out.println("videoname:"+videoname+"videodesp:"+videodesp+"uploaduser:"+uploaduser);
        FileOutputStream fos = null;
        FileInputStream fis = null;
        String path = "/media/video";
        try {
            fos = new FileOutputStream(path + "/" + getVideoFileName());
            // 建立文件上传流
            fis = new FileInputStream(getVideo());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            System.out.println("文件上传失败");
            e.printStackTrace();
            return INPUT;
        } finally {
            close(fos, fis);
        }
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setvName(videoname);
        videoEntity.setIntroduce(videodesp);
        videoEntity.setvUrl(path);
        videoEntity.settName(uploaduser);
        //上传日期
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr = sdf.format(date);
        videoEntity.setTime(datestr);
        //得到老师id
        UserEntity user = (UserEntity)ActionContext.getContext().getSession().get("user");
        if(user!=null){
        	videoEntity.setId(user.getId());
        }
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int result = session.insert("video.insert", videoEntity);
		session.commit();
		if(session!=null){
			session.close();
		}
		System.out.println("result:"+result);
        return SUCCESS;
    }

    /**
     * 返回上传文件的保存位置
     * 
     * @return
     */

    public File getVideo() {
		return video;
	}

	public void setVideo(File video) {
		this.video = video;
	}

	public String getVideoContentType() {
		return videoContentType;
	}

	public void setVideoContentType(String videoContentType) {
		this.videoContentType = videoContentType;
	}

	public String getVideoFileName() {
		return videoFileName;
	}

	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	public String getVideodesp() {
		return videodesp;
	}

	public void setVideodesp(String videodesp) {
		this.videodesp = videodesp;
	}

	public String getUploaduser() {
		return uploaduser;
	}

	public void setUploaduser(String uploaduser) {
		this.uploaduser = uploaduser;
	}

	private void close(FileOutputStream fos, FileInputStream fis) {
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("FileInputStream关闭失败");
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("FileOutputStream关闭失败");
                e.printStackTrace();
            }
        }
    }
}
