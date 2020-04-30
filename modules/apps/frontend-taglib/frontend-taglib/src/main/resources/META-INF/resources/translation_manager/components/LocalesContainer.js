/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayTabs from '@clayui/tabs';
import React from 'react';

export default function LocalesContainer({children, ...otherProps}) {
	return (
		<ClayTabs {...otherProps} className="lfr-translationmanager" modern>
			{children}
		</ClayTabs>
	);
}
