/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {fetch} from 'frontend-js-web';
import {globalEval} from 'metal-dom';
import PropTypes from 'prop-types';
import React, {useEffect, useLayoutEffect, useRef, useState} from 'react';

function Captcha({uri}) {
	const ref = useRef(null);
	const [html, setHtml] = useState(null);

	useEffect(() => {
		fetch(uri)
			.then(res => res.text())
			.then(setHtml);
	}, [uri]);

	useLayoutEffect(() => {
		if (html) {
			ref.current.innerHTML = html;
			globalEval.runScriptsInElement(ref.current);
		}
	}, [html]);

	return html ? <div className="captcha w-50" ref={ref} /> : null;
}

Captcha.propTypes = {
	uri: PropTypes.string.isRequired,
};

export default Captcha;
