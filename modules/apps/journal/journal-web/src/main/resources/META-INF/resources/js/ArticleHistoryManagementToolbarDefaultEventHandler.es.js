/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';

class ArticleHistoryManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	deleteArticles(itemData) {
		if (
			confirm(
				Liferay.Language.get(
					'are-you-sure-you-want-to-delete-the-selected-version'
				)
			)
		) {
			submitForm(this.one('#fm'), itemData.deleteArticlesURL);
		}
	}

	expireArticles(itemData) {
		if (
			confirm(
				Liferay.Language.get(
					'are-you-sure-you-want-to-expire-the-selected-version'
				)
			)
		) {
			submitForm(this.one('#fm'), itemData.expireArticlesURL);
		}
	}
}

export default ArticleHistoryManagementToolbarDefaultEventHandler;
