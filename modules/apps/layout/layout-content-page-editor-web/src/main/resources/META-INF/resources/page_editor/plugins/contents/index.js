/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {Component} from '../../core/AppContext';
import ContentsSidebar from './components/ContentsSidebar';

/**
 * Entry-point for "Contents" (sidebar pane) functionality.
 */
export default class Contents {
	constructor({app, panel}) {
		this.Component = Component(app);
		this.title = panel.label;
	}

	renderSidebar() {
		const {Component} = this;

		return (
			<Component>
				<ContentsSidebar title={this.title} />
			</Component>
		);
	}
}
