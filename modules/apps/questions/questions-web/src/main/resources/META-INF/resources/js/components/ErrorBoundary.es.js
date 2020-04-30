/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayAlert from '@clayui/alert';
import React from 'react';

export class ErrorBoundary extends React.Component {
	constructor(props) {
		super(props);
		this.state = {hasError: false};
	}

	static getDerivedStateFromError(error) {
		return {error, hasError: true};
	}

	componentDidCatch(_error, _errorInfo) {}

	render() {
		if (this.state.hasError) {
			return (
				<>
					<ClayAlert
						autoClose={5000}
						displayType="danger"
						title={'Error:'}
					>
						{'Could not load the page'}
					</ClayAlert>
				</>
			);
		}

		return this.props.children;
	}
}
