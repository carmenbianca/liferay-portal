/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayLoadingIndicator from '@clayui/loading-indicator';
import {useIsMounted} from 'frontend-js-react-web';
import {fetch} from 'frontend-js-web';
import {globalEval} from 'metal-dom';
import React, {useEffect, useState} from 'react';

export default function BasicInfoPanel({url}) {
	const [loading, setLoading] = useState(true);
	const [content, setContent] = useState('');
	const isMounted = useIsMounted();

	useEffect(() => {
		fetch(url)
			.then(response => response.text())
			.then(content => {
				if (isMounted()) {
					setContent(content);
					setLoading(false);
				}
			})
			.catch(error => {
				if (process.env.NODE_ENV === 'development') {
					console.error(error);
				}
			});
	}, [isMounted, url]);

	return (
		<div className="sidebar-sm">
			<div className="sidebar-header">
				<p className="component-title h4">
					{Liferay.Language.get('properties')}
				</p>
			</div>
			<div className="sidebar-body">
				{loading ? (
					<ClayLoadingIndicator />
				) : (
					<BasicInfoPanelBody content={content} />
				)}
			</div>
		</div>
	);
}

class BasicInfoPanelBody extends React.Component {
	constructor(props) {
		super(props);

		this._ref = React.createRef();
	}

	componentDidMount() {
		if (this._ref.current) {
			globalEval.runScriptsInElement(this._ref.current);

			this._ref.current.addEventListener('change', this._handleOnChange);
		}
	}
	shouldComponentUpdate() {
		return false;
	}

	render() {
		return (
			<div
				dangerouslySetInnerHTML={{__html: this.props.content}}
				ref={this._ref}
			/>
		);
	}
}
