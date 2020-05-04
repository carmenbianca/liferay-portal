/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {PagesVisitor} from '../../util/visitors.es';

export default (pages, properties) => {
	const {fieldInstance} = properties;
	const pageVisitor = new PagesVisitor(pages);

	return Promise.resolve(
		pageVisitor.mapFields(field => {
			const focused = field.name === fieldInstance.name;

			return {
				...field,
				focused,
			};
		})
	);
};
