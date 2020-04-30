/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {useIsMounted} from 'frontend-js-react-web';
import React, {useEffect, useState} from 'react';
import {createPortal} from 'react-dom';

export default function Frame({children}) {
	const [iframe, setIframe] = useState();
	const [iframeBody, setIframeBody] = useState();
	const isMounted = useIsMounted();

	useEffect(() => {
		let intervalId = null;

		if (iframe) {
			let body;

			intervalId = setInterval(() => {
				if (isMounted() && body !== iframe.contentDocument.body) {
					body = iframe.contentDocument.body;
					setIframeBody(body);
				}
			}, 500);
		}

		return () => {
			clearInterval(intervalId);
		};
	}, [iframe, isMounted]);

	return (
		<>
			<iframe className="page-editor__frame" ref={setIframe}></iframe>
			{iframeBody && createPortal(children, iframeBody)}
		</>
	);
}
