package com.buffettinc.hrms.model.pto;

/**
 * Represents the different reason that an {@link com.buffettinc.hrms.model.employee.Employee} would submit a
 * {@link PTORequest}, such as sick, personal, vacation, jury duty, military leave, etc.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public enum PTOReason {
    SICK, PERSONAL, VACATION, BEREAVEMENT, JURY_DUTY, MILITARY_LEAVE, LEAVE_OF_ABSENCE
}