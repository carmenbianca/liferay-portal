/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayLoadingIndicator from '@clayui/loading-indicator';
import React from 'react';

export const withLoading = Component => {
	const Wrapper = props => {
		const {isLoading, ...restProps} = props;

		if (isLoading) {
			return (
				<div className="align-items-center d-flex loading-wrapper">
					<ClayLoadingIndicator />
				</div>
			);
		}

		return <Component {...restProps} />;
	};

	return Wrapper;
};

export const Loading = withLoading(({children}) => <>{children}</>);
