/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {evaluate} from '../../util/evaluation.es';

export default (evaluatorContext, dispatch) => {
	const {activePage, formId, pages} = evaluatorContext;

	return evaluate(null, evaluatorContext).then(evaluatedPages => {
		let previousActivePageIndex = activePage;

		for (let i = activePage - 1; i > -1; i--) {
			if (evaluatedPages[i].enabled) {
				previousActivePageIndex = i;

				break;
			}
		}

		const activePageUpdated = Math.max(previousActivePageIndex, 0);

		dispatch('activePageUpdated', activePageUpdated);

		Liferay.fire('ddmFormPageShow', {
			formId,
			page: activePageUpdated,
			title: pages[activePageUpdated].title,
		});
	});
};
