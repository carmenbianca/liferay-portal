/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayAlert from '@clayui/alert';
import React from 'react';

export default function NoPageContents() {
	return (
		<ClayAlert
			className="m-3"
			displayType="info"
			title={Liferay.Language.get('info')}
		>
			{Liferay.Language.get('there-is-no-content-on-this-page')}
		</ClayAlert>
	);
}
