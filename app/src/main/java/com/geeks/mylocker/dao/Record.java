package com.geeks.mylocker.dao;

import java.util.List;

import com.geeks.mylocker.dao.DaoSession;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table RECORD.
 */
public class Record implements Entity {

    private Long id;
    /** Not-null value. */
    private String name;
    /** Not-null value. */
    private String userId;
    /** Not-null value. */
    private String userPassword;
    private java.util.Date createdDate;
    private long folderId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient RecordDao myDao;

    private Folder folder;
    private Long folder__resolvedKey;

    private List<Field> fields;

    public Record() {
    }

    public Record(Long id) {
        this.id = id;
    }

    public Record(Long id, String name, String userId, String userPassword, java.util.Date createdDate, long folderId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.userPassword = userPassword;
        this.createdDate = createdDate;
        this.folderId = folderId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRecordDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    /** Not-null value. */
    public String getUserId() {
        return userId;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** Not-null value. */
    public String getUserPassword() {
        return userPassword;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public java.util.Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getFolderId() {
        return folderId;
    }

    public void setFolderId(long folderId) {
        this.folderId = folderId;
    }

    /** To-one relationship, resolved on first access. */
    public Folder getFolder() {
        long __key = this.folderId;
        if (folder__resolvedKey == null || !folder__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FolderDao targetDao = daoSession.getFolderDao();
            Folder folderNew = targetDao.load(__key);
            synchronized (this) {
                folder = folderNew;
            	folder__resolvedKey = __key;
            }
        }
        return folder;
    }

    public void setFolder(Folder folder) {
        if (folder == null) {
            throw new DaoException("To-one property 'folderId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.folder = folder;
            folderId = folder.getId();
            folder__resolvedKey = folderId;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Field> getFields() {
        if (fields == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FieldDao targetDao = daoSession.getFieldDao();
            List<Field> fieldsNew = targetDao._queryRecord_Fields(id);
            synchronized (this) {
                if(fields == null) {
                    fields = fieldsNew;
                }
            }
        }
        return fields;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetFields() {
        fields = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
