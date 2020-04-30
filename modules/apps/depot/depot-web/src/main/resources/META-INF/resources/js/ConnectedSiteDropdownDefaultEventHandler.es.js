/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DefaultEventHandler} from 'frontend-js-web';

class ConnectedSiteDropdownDefaultEventHandler extends DefaultEventHandler {
	disconnect(itemData) {
		if (
			confirm(
				Liferay.Language.get(
					'removing-this-site-connection-will-not-allow-the-site-to-consume-data-from-this-asset-library-directly'
				)
			)
		) {
			submitForm(document.hrefFm, itemData.disconnectSiteActionURL);
		}
	}
}

export default ConnectedSiteDropdownDefaultEventHandler;
