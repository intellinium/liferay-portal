/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.social.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.social.model.SocialEquityLog;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the SocialEquityLog table in the
 * database.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SocialEquityLogImpl
 * @see       com.liferay.portlet.social.model.SocialEquityLog
 * @see       com.liferay.portlet.social.model.SocialEquityLogModel
 * @generated
 */
public class SocialEquityLogModelImpl extends BaseModelImpl<SocialEquityLog> {
	public static final String TABLE_NAME = "SocialEquityLog";
	public static final Object[][] TABLE_COLUMNS = {
			{ "equityLogId", new Integer(Types.BIGINT) },
			{ "groupId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "userId", new Integer(Types.BIGINT) },
			{ "assetEntryId", new Integer(Types.BIGINT) },
			{ "actionId", new Integer(Types.VARCHAR) },
			{ "actionDate", new Integer(Types.INTEGER) },
			{ "active_", new Integer(Types.BOOLEAN) },
			{ "expiration", new Integer(Types.INTEGER) },
			{ "type_", new Integer(Types.INTEGER) },
			{ "value", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table SocialEquityLog (equityLogId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,assetEntryId LONG,actionId VARCHAR(75) null,actionDate INTEGER,active_ BOOLEAN,expiration INTEGER,type_ INTEGER,value INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table SocialEquityLog";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.social.model.SocialEquityLog"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.social.model.SocialEquityLog"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.social.model.SocialEquityLog"));

	public SocialEquityLogModelImpl() {
	}

	public long getPrimaryKey() {
		return _equityLogId;
	}

	public void setPrimaryKey(long pk) {
		setEquityLogId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_equityLogId);
	}

	public long getEquityLogId() {
		return _equityLogId;
	}

	public void setEquityLogId(long equityLogId) {
		_equityLogId = equityLogId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = userId;
		}
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	public long getAssetEntryId() {
		return _assetEntryId;
	}

	public void setAssetEntryId(long assetEntryId) {
		_assetEntryId = assetEntryId;

		if (!_setOriginalAssetEntryId) {
			_setOriginalAssetEntryId = true;

			_originalAssetEntryId = assetEntryId;
		}
	}

	public long getOriginalAssetEntryId() {
		return _originalAssetEntryId;
	}

	public String getActionId() {
		if (_actionId == null) {
			return StringPool.BLANK;
		}
		else {
			return _actionId;
		}
	}

	public void setActionId(String actionId) {
		_actionId = actionId;

		if (_originalActionId == null) {
			_originalActionId = actionId;
		}
	}

	public String getOriginalActionId() {
		return GetterUtil.getString(_originalActionId);
	}

	public int getActionDate() {
		return _actionDate;
	}

	public void setActionDate(int actionDate) {
		_actionDate = actionDate;

		if (!_setOriginalActionDate) {
			_setOriginalActionDate = true;

			_originalActionDate = actionDate;
		}
	}

	public int getOriginalActionDate() {
		return _originalActionDate;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = active;
		}
	}

	public boolean getOriginalActive() {
		return _originalActive;
	}

	public int getExpiration() {
		return _expiration;
	}

	public void setExpiration(int expiration) {
		_expiration = expiration;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = type;
		}
	}

	public int getOriginalType() {
		return _originalType;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	public SocialEquityLog toEscapedModel() {
		if (isEscapedModel()) {
			return (SocialEquityLog)this;
		}
		else {
			return (SocialEquityLog)Proxy.newProxyInstance(SocialEquityLog.class.getClassLoader(),
				new Class[] { SocialEquityLog.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					SocialEquityLog.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		SocialEquityLogImpl clone = new SocialEquityLogImpl();

		clone.setEquityLogId(getEquityLogId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setAssetEntryId(getAssetEntryId());
		clone.setActionId(getActionId());
		clone.setActionDate(getActionDate());
		clone.setActive(getActive());
		clone.setExpiration(getExpiration());
		clone.setType(getType());
		clone.setValue(getValue());

		return clone;
	}

	public int compareTo(SocialEquityLog socialEquityLog) {
		long pk = socialEquityLog.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SocialEquityLog socialEquityLog = null;

		try {
			socialEquityLog = (SocialEquityLog)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = socialEquityLog.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{equityLogId=");
		sb.append(getEquityLogId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", assetEntryId=");
		sb.append(getAssetEntryId());
		sb.append(", actionId=");
		sb.append(getActionId());
		sb.append(", actionDate=");
		sb.append(getActionDate());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", expiration=");
		sb.append(getExpiration());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.social.model.SocialEquityLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>equityLogId</column-name><column-value><![CDATA[");
		sb.append(getEquityLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetEntryId</column-name><column-value><![CDATA[");
		sb.append(getAssetEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionId</column-name><column-value><![CDATA[");
		sb.append(getActionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionDate</column-name><column-value><![CDATA[");
		sb.append(getActionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiration</column-name><column-value><![CDATA[");
		sb.append(getExpiration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _equityLogId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _assetEntryId;
	private long _originalAssetEntryId;
	private boolean _setOriginalAssetEntryId;
	private String _actionId;
	private String _originalActionId;
	private int _actionDate;
	private int _originalActionDate;
	private boolean _setOriginalActionDate;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private int _expiration;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private int _value;
	private transient ExpandoBridge _expandoBridge;
}