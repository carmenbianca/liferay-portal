/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {PagesVisitor} from '../../util/visitors.es';

export default (pages, name) => {
	const visitor = new PagesVisitor(pages);

	return visitor.mapColumns(column => {
		return {
			...column,
			fields: column.fields.filter(field => field.name !== name),
		};
	});
};
