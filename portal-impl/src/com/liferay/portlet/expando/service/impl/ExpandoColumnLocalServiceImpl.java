/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.expando.service.impl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.expando.ColumnNameException;
import com.liferay.portlet.expando.ColumnTypeException;
import com.liferay.portlet.expando.DuplicateColumnNameException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.impl.ExpandoColumnImpl;
import com.liferay.portlet.expando.service.base.ExpandoColumnLocalServiceBaseImpl;

import java.util.List;

/**
 * <a href="ExpandoColumnLocalServiceImpl.java.html"><b><i>View Source</i></b>
 * </a>
 *
 * @author Raymond Augé
 * @author Brian Wing Shun Chan
 *
 */
public class ExpandoColumnLocalServiceImpl
	extends ExpandoColumnLocalServiceBaseImpl {

	public ExpandoColumn addColumn(long tableId, String name, int type)
		throws PortalException, SystemException {

		validate(0, tableId, name, type);

		long columnId = counterLocalService.increment();

		ExpandoColumn column = expandoColumnPersistence.create(columnId);

		column.setTableId(tableId);
		column.setName(name);
		column.setType(type);

		expandoColumnPersistence.update(column, false);

		return column;
	}

	public void deleteColumn(long columnId)
		throws PortalException, SystemException {

		// Values

		expandoValueLocalService.deleteColumnValues(columnId);

		// Column

		expandoColumnPersistence.remove(columnId);
	}

	public void deleteColumns(long tableId)
		throws PortalException, SystemException {

		List<ExpandoColumn> columns = expandoColumnPersistence.findByTableId(
			tableId);

		for (ExpandoColumn column : columns) {
			deleteColumn(column.getColumnId());
		}
	}

	public ExpandoColumn getColumn(long columnId)
		throws PortalException, SystemException {

		return expandoColumnPersistence.findByPrimaryKey(columnId);
	}

	public ExpandoColumn getColumn(long tableId, String name)
		throws PortalException, SystemException {

		return expandoColumnPersistence.findByT_N(tableId, name);
	}

	public List<ExpandoColumn> getColumns(long tableId)
		throws SystemException {

		return expandoColumnPersistence.findByTableId(tableId);
	}

	public int getColumnsCount(long tableId) throws SystemException {
		return expandoColumnPersistence.countByTableId(tableId);
	}

	public ExpandoColumn updateColumn(long columnId, String name, int type)
		throws PortalException, SystemException {

		ExpandoColumn column = expandoColumnPersistence.findByPrimaryKey(
			columnId);

		validate(columnId, column.getTableId(), name, type);

		column.setName(name);
		column.setType(type);

		expandoColumnPersistence.update(column, false);

		return column;
	}

	protected void validate(long columnId, long tableId, String name, int type)
		throws PortalException, SystemException {

		if (Validator.isNull(name)) {
			throw new ColumnNameException();
		}

		ExpandoColumn column = expandoColumnPersistence.fetchByT_N(
			tableId, name);

		if ((column != null) && (column.getColumnId() != columnId)) {
			throw new DuplicateColumnNameException();
		}

		if ((type != ExpandoColumnImpl.BOOLEAN) &&
			(type != ExpandoColumnImpl.BOOLEAN_ARRAY) &&
			(type != ExpandoColumnImpl.DATE) &&
			(type != ExpandoColumnImpl.DATE_ARRAY) &&
			(type != ExpandoColumnImpl.DOUBLE) &&
			(type != ExpandoColumnImpl.DOUBLE_ARRAY) &&
			(type != ExpandoColumnImpl.FLOAT) &&
			(type != ExpandoColumnImpl.FLOAT_ARRAY) &&
			(type != ExpandoColumnImpl.INTEGER) &&
			(type != ExpandoColumnImpl.INTEGER_ARRAY) &&
			(type != ExpandoColumnImpl.LONG) &&
			(type != ExpandoColumnImpl.LONG_ARRAY) &&
			(type != ExpandoColumnImpl.SHORT) &&
			(type != ExpandoColumnImpl.SHORT_ARRAY) &&
			(type != ExpandoColumnImpl.STRING) &&
			(type != ExpandoColumnImpl.STRING_ARRAY)) {

			throw new ColumnTypeException();
		}
	}

}