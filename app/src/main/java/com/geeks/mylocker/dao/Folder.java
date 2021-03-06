package com.geeks.mylocker.dao;

import java.util.List;

import com.geeks.mylocker.dao.DaoSession;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table FOLDER.
 */
public class Folder implements Entity {

    private Long id;
    /** Not-null value. */
    private String name;
    private java.util.Date createdDate;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient FolderDao myDao;

    private List<Record> records;

    public Folder() {
    }

    public Folder(Long id) {
        this.id = id;
    }

    public Folder(Long id, String name, java.util.Date createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFolderDao() : null;
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

    public java.util.Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Record> getRecords() {
        if (records == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RecordDao targetDao = daoSession.getRecordDao();
            List<Record> recordsNew = targetDao._queryFolder_Records(id);
            synchronized (this) {
                if(records == null) {
                    records = recordsNew;
                }
            }
        }
        return records;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetRecords() {
        records = null;
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
