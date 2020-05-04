/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useEffect, useState} from 'react';

const removeCollapseHeight = collapseElementRef => {
	if (collapseElementRef && collapseElementRef.current) {
		collapseElementRef.current.style.removeProperty('height');
	}
};

const setCollapseHeight = collapseElementRef => {
	if (collapseElementRef && collapseElementRef.current) {
		const height = Array.prototype.slice
			.call(collapseElementRef.current.children)
			.reduce((acc, child) => acc + child.clientHeight, 0);

		collapseElementRef.current.setAttribute('style', `height: ${height}px`);
	}
};

export default (visible, setVisible, contentRef) => {
	const [transitioning, setTransitioning] = useState(false);

	useEffect(() => {
		if (transitioning) {
			setCollapseHeight(contentRef);
			if (visible) {
				removeCollapseHeight(contentRef);
			}
		}
	}, [contentRef, transitioning, visible]);

	const handleTransitionEnd = event => {
		if (event.target === contentRef.current && transitioning && !visible) {
			setVisible(true);
			setTransitioning(false);
			removeCollapseHeight(contentRef);
		}
		else if (event.target === contentRef.current) {
			setVisible(false);
			setTransitioning(false);
		}
	};

	const startTransition = event => {
		event.preventDefault();

		if (visible && !transitioning) {
			setCollapseHeight(contentRef);
		}

		if (!transitioning) {
			setTransitioning(true);
		}
	};

	return [transitioning, handleTransitionEnd, startTransition];
};
