package com.briup.service.impl;

import java.util.List;

import com.briup.bean.Report;
import com.briup.common.exception.ReportException;
import com.briup.dao.impl.ReportDaoImpl;
import com.briup.service.IReportService;

public class ReportServoceImpl implements IReportService{
private ReportDaoImpl reportDaoImpl =new ReportDaoImpl();

	@Override
	public void saveReport(Report report) throws ReportException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReport(Report report) throws ReportException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delReport(Long reportId) throws ReportException {
		// TODO Auto-generated method stub
		
	}
/*
 * 获取所有快报信息
 */
	@Override
	public List<Report> listReport() throws ReportException {
		// TODO Auto-generated method stub
		String sql="select * from s_report";
		List<Report> reports = reportDaoImpl.find(sql, null, Report.class);
		return reports;
	}

	@Override
	public Report selectReportById(long id) throws ReportException {
		// TODO Auto-generated method stub
		return null;
	}

}
