package com.briup.service;

import java.util.List;

import com.briup.bean.Report;
import com.briup.common.exception.ReportException;


public interface IReportService {
	/**
	 * 添加公告
	 * */
	void saveReport(Report report) throws ReportException;
	/**
	 * 修改公告
	 * */
	void updateReport(Report report) throws ReportException;
	/**
	 * 删除公告
	 * */
	void delReport(Long reportId) throws ReportException;
	/**
	 * 列出公告
	 * */
	List<Report> listReport() throws ReportException;
	/**
	 * 查看公告
	 * */
	Report selectReportById(long id) throws ReportException;
	
}