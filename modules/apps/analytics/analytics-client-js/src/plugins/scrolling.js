/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {DEBOUNCE} from '../utils/constants';
import {debounce} from '../utils/debounce';
import {ScrollTracker} from '../utils/scroll';

const applicationId = 'Page';

/**
 * Plugin function that registers listener against scroll event
 * @param {Object} analytics The Analytics client
 */
function scrolling(analytics) {
	let scrollTracker = new ScrollTracker();

	const onScroll = debounce(() => {
		scrollTracker.onDepthReached(depth => {
			analytics.send('pageDepthReached', applicationId, {depth});
		});
	}, DEBOUNCE);

	document.addEventListener('scroll', onScroll);

	// Reset levels on SPA-enabled environments

	const onLoad = () => {
		scrollTracker.dispose();
		scrollTracker = new ScrollTracker();
	};

	window.addEventListener('load', onLoad);

	return () => {
		document.removeEventListener('scroll', onScroll);
		window.removeEventListener('load', onLoad);
	};
}

export {scrolling};
export default scrolling;
