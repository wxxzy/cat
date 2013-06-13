package com.dianping.cat.system.page.config;

import org.unidal.web.mvc.ActionContext;
import org.unidal.web.mvc.ActionPayload;
import org.unidal.web.mvc.payload.annotation.FieldMeta;
import org.unidal.web.mvc.payload.annotation.ObjectMeta;

import com.dianping.cat.consumer.core.dal.Project;
import com.dianping.cat.home.company.entity.ProductLine;
import com.dianping.cat.home.dal.report.AggregationRule;
import com.dianping.cat.home.dependency.config.entity.DomainConfig;
import com.dianping.cat.home.dependency.config.entity.EdgeConfig;
import com.dianping.cat.system.SystemPage;

public class Payload implements ActionPayload<SystemPage, Action> {
	@FieldMeta("op")
	private Action m_action;

	private SystemPage m_page;

	@ObjectMeta("project")
	private Project m_project = new Project();

	@ObjectMeta("productLine")
	private ProductLine m_productLine = new ProductLine();

	@ObjectMeta("aggregation")
	private AggregationRule m_rule = new AggregationRule();

	@ObjectMeta("domainConfig")
	private DomainConfig m_domainConfig = new DomainConfig();

	@ObjectMeta("edgeConfig")
	private EdgeConfig m_edgeConfig = new EdgeConfig();

	@FieldMeta("projectId")
	private int m_projectId;

	@FieldMeta("productLineName")
	private String m_productLineName;

	@FieldMeta("domain")
	private String m_domain;

	@FieldMeta("domains")
	private String[] m_domains = new String[100];

	@FieldMeta("from")
	private String m_from;

	@FieldMeta("id")
	private int m_id;

	@FieldMeta("type")
	private String m_type;

	@FieldMeta("to")
	private String m_to;

	@Override
	public Action getAction() {
		if (m_action == null) {
			m_action = Action.PROJECT_ALL;
		}
		return m_action;
	}

	public DomainConfig getDomainConfig() {
		return m_domainConfig;
	}

	public EdgeConfig getEdgeConfig() {
		return m_edgeConfig;
	}

	public int getId() {
		return m_id;
	}

	@Override
	public SystemPage getPage() {
		return m_page;
	}

	public Project getProject() {
		return m_project;
	}

	public int getProjectId() {
		return m_projectId;
	}

	public String getReportType() {
		return "";
	}

	public AggregationRule getRule() {
		return m_rule;
	}

	public String getType() {
		return m_type;
	}

	public void setAction(String action) {
		m_action = Action.getByName(action, Action.PROJECT_ALL);
	}

	public void setDomainConfig(DomainConfig domainConfig) {
		m_domainConfig = domainConfig;
	}

	public void setEdgeConfig(EdgeConfig edgeConfig) {
		m_edgeConfig = edgeConfig;
	}

	public void setId(int id) {
		m_id = id;
	}

	@Override
	public void setPage(String page) {
		m_page = SystemPage.getByName(page, SystemPage.CONFIG);
	}

	public void setProject(Project project) {
		m_project = project;
	}

	public void setProjectId(int id) {
		m_projectId = id;
	}

	public void setRule(AggregationRule rule) {
		m_rule = rule;
	}

	public void setType(String type) {
		if (type.startsWith("Cache.")) {
			type = "Cache";
		}
		if (type.equals("Call")) {
			type = "PigeonCall";
		}
		if (type.equals("Service")) {
			type = "PigeonService";
		}
		m_type = type;
	}

	public String getDomain() {
		return m_domain;
	}

	public void setDomain(String domain) {
		m_domain = domain;
	}

	@Override
	public void validate(ActionContext<?> ctx) {
	}

	public String getTo() {
		return m_to;
	}

	public void setTo(String to) {
		m_to = to;
	}

	public String getFrom() {
		return m_from;
	}

	public void setFrom(String from) {
		m_from = from;
	}

	public ProductLine getProductLine() {
		return m_productLine;
	}

	public void setProductLine(ProductLine productLine) {
		m_productLine = productLine;
	}

	public String getProductLineName() {
		return m_productLineName;
	}

	public void setProductLineName(String productLineName) {
		m_productLineName = productLineName;
	}

	public String[] getDomains() {
		return m_domains;
	}

	public void setDomains(String[] domains) {
		m_domains = domains;
	}

}
