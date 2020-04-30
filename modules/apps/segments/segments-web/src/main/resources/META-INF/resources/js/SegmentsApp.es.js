/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import ThemeContext from './ThemeContext.es';
import SegmentEdit from './components/segment_edit/SegmentEdit.es';

export default function({context, props}) {
	return (
		<ThemeContext.Provider value={context}>
			<div className="segments-root">
				<SegmentEdit {...props} />
			</div>
		</ThemeContext.Provider>
	);
}
