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
			const matches =
				field.name === fieldInstance.name &&
				field.required &&
				fieldInstance.value == '';

			return {
				...field,
				displayErrors: !!field.displayErrors || matches,
				focused: matches ? false : field.focused,
			};
		})
	);
};
