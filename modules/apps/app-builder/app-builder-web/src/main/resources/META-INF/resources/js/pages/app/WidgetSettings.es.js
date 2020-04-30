/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayAlert from '@clayui/alert';
import React, {useState} from 'react';

export default () => {
	const [show, setShow] = useState(true);

	return (
		show && (
			<div className="autofit-row pl-4 pr-4">
				<div className="autofit-col-expand">
					<ClayAlert
						displayType="info"
						onClose={() => setShow(!show)}
						title={`${Liferay.Language.get('info')}:`}
					>
						{Liferay.Language.get(
							'the-widget-will-be-available-under-add-widgets-app-builder'
						)}
					</ClayAlert>
				</div>
			</div>
		)
	);
};
