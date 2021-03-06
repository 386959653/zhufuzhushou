package com.weichi.erp.domain;

public class UserGroup extends SuperDomain<UserGroup> {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.user_id
     *
     * @mbggenerated Fri Jun 22 17:38:03 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.group_id
     *
     * @mbggenerated Fri Jun 22 17:38:03 CST 2018
     */
    private Long groupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_group.group_role
     *
     * @mbggenerated Fri Jun 22 17:38:03 CST 2018
     */
    private String groupRole;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.user_id
     *
     * @return the value of user_group.user_id
     *
     * @mbggenerated Fri Jun 22 17:38:03 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.user_id
     *
     * @param userId the value for user_group.user_id
     *
     * @mbggenerated Fri Jun 22 17:38:03 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.group_id
     *
     * @return the value of user_group.group_id
     *
     * @mbggenerated Fri Jun 22 17:38:03 CST 2018
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.group_id
     *
     * @param groupId the value for user_group.group_id
     *
     * @mbggenerated Fri Jun 22 17:38:03 CST 2018
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_group.group_role
     *
     * @return the value of user_group.group_role
     *
     * @mbggenerated Fri Jun 22 17:38:03 CST 2018
     */
    public String getGroupRole() {
        return groupRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_group.group_role
     *
     * @param groupRole the value for user_group.group_role
     *
     * @mbggenerated Fri Jun 22 17:38:03 CST 2018
     */
    public void setGroupRole(String groupRole) {
        this.groupRole = groupRole;
    }
}