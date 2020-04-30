/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayAlert from '@clayui/alert';
import React from 'react';

export default ({error: {message, title}}) => (
	<>
		{title && (
			<ClayAlert.ToastContainer>
				<ClayAlert displayType="danger" title={title}>
					{message}
				</ClayAlert>
			</ClayAlert.ToastContainer>
		)}
	</>
);
