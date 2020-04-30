/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import './CaptchaRegister.soy';

import {globalEval} from 'metal-dom';
import React, {useEffect, useMemo, useRef} from 'react';

import {FieldBaseProxy} from '../FieldBase/ReactFieldBase.es';
import getConnectedReactComponentAdapter from '../util/ReactComponentAdapter.es';
import {connectStore} from '../util/connectStore.es';
import templates from './CaptchaAdapter.soy';

const Captcha = ({html, name}) => {
	// eslint-disable-next-line react-hooks/exhaustive-deps
	const contentMemoized = useMemo(() => html, []);
	const elRef = useRef(null);

	useEffect(() => {
		if (window.grecaptcha) {
			window.grecaptcha.ready(() => {
				try {
					window.grecaptcha.reset();
				}
				catch (error) {
					console.warn('Could not reset reCAPTCHA');
				}
			});
		}
	}, []);

	useEffect(() => {
		if (elRef.current) {
			globalEval.runScriptsInElement(elRef.current);
		}
	}, [elRef]);

	useEffect(() => {
		if (elRef.current) {
			const fieldIndex = name.indexOf('_ddm');
			Liferay.fire(
				`${name.substring(0, fieldIndex)}_simplecaptcha_attachEvent`
			);
		}
	}, [elRef, name]);

	return (
		<>
			<div
				dangerouslySetInnerHTML={{__html: contentMemoized}}
				ref={elRef}
			/>
			<input id={name} type="hidden" />
		</>
	);
};

const CaptchaProxy = connectStore(({dispatch, html, name, ...otherProps}) => (
	<FieldBaseProxy
		{...otherProps}
		dispatch={dispatch}
		name={name}
		visible={true}
	>
		<Captcha html={html.content} name={name} />
	</FieldBaseProxy>
));

const ReactCaptchaAdapter = getConnectedReactComponentAdapter(
	CaptchaProxy,
	templates
);

export {ReactCaptchaAdapter};
export default ReactCaptchaAdapter;
