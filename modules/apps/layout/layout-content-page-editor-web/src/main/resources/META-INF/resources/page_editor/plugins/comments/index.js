/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {Component} from '../../core/AppContext';
import CommentsSidebar from './components/CommentsSidebar';

/**
 * Entry-point for "Comments" (sidebar pane) functionality.
 */
export default class Comments {
	constructor({app, panel}) {
		this.Component = Component(app);
		this.title = panel.label;
	}

	renderSidebar() {
		const {Component} = this;

		return (
			<Component>
				<CommentsSidebar title={this.title} />
			</Component>
		);
	}
}
