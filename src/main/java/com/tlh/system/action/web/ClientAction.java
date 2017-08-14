package com.tlh.system.action.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tlh.entity.Client;
import com.tlh.util.FileUtil;
import com.tlh.view.ParameterObject;

@Controller
@RequestMapping({ "/web/clientAction" })
public class ClientAction {
	@RequestMapping({ "/index" })
	public String index() {
		return "admin/client/index";
	}

	@RequestMapping({ "/uploadClient" })
	@ResponseBody
	public ParameterObject uploadClient(HttpServletRequest request, Client client) {
		ParameterObject result = new ParameterObject();
		client.setUrl(request.getLocalAddr() + request.getContextPath() + client.getUrl());
		boolean flag = FileUtil.generateXmlFile(client, request.getServletContext().getRealPath("/upload"));
		if (flag)
			result.msg("操作成功！");
		else {
			result.msg("操作失败！");
		}
		result.flag(Boolean.valueOf(flag));
		return result;
	}
}