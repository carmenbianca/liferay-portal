/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {evaluate} from '../../util/evaluation.es';
import {PagesVisitor} from '../../util/visitors.es';

export default (evaluatorContext, dispatch) => {
	const {activePage, formId, pages} = evaluatorContext;

	return evaluate(null, evaluatorContext).then(evaluatedPages => {
		let validPage = true;
		const visitor = new PagesVisitor(evaluatedPages);

		visitor.mapFields(
			({valid}, fieldIndex, columnIndex, rowIndex, pageIndex) => {
				if (activePage === pageIndex && !valid) {
					validPage = false;
				}
			}
		);

		if (validPage) {
			const nextActivePageIndex = evaluatedPages.findIndex(
				({enabled}, index) => {
					let found = false;

					if (enabled && index > activePage) {
						found = true;
					}

					return found;
				}
			);

			const activePageUpdated = Math.min(
				nextActivePageIndex,
				pages.length - 1
			);

			dispatch('activePageUpdated', activePageUpdated);

			Liferay.fire('ddmFormPageShow', {
				formId,
				page: activePageUpdated,
				title: pages[activePageUpdated].title,
			});
		}
		else {
			dispatch('pageValidationFailed', activePage);
		}
	});
};
