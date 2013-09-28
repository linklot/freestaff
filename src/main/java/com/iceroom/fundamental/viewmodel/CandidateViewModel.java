package com.iceroom.fundamental.viewmodel;

import java.util.List;

import com.iceroom.fundamental.entity.EduHistory;
import com.iceroom.fundamental.entity.EmpHistory;

/**
 * The Candidate view model
 * @author Lincoln
 *
 */
public class CandidateViewModel {
    
    private List<EmpHistory> empHistories;
    private List<EduHistory> eduHistories;

    /**
     * @return the empHistories
     */
    public List<EmpHistory> getEmpHistories() {
        return empHistories;
    }

    /**
     * @param empHistories the empHistories to set
     */
    public void setEmpHistories(List<EmpHistory> empHistories) {
        this.empHistories = empHistories;
    }

    /**
     * @return the eduHistories
     */
    public List<EduHistory> getEduHistories() {
        return eduHistories;
    }

    /**
     * @param eduHistories the eduHistories to set
     */
    public void setEduHistories(List<EduHistory> eduHistories) {
        this.eduHistories = eduHistories;
    }

}
