/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import './ParagraphRegister.soy';

import React from 'react';

import {FieldBaseProxy} from '../FieldBase/ReactFieldBase.es';
import getConnectedReactComponentAdapter from '../util/ReactComponentAdapter.es';
import {connectStore} from '../util/connectStore.es';
import templates from './ParagraphAdapter.soy';

const Paragraph = ({name, text}) => (
	<div
		className="form-group liferay-ddm-form-field-paragraph"
		data-field-name={name}
	>
		<div
			className="liferay-ddm-form-field-paragraph-text"
			dangerouslySetInnerHTML={{
				__html: typeof text === 'object' ? text.content : text,
			}}
		/>
	</div>
);

const ParagraphProxy = connectStore(({name, text, ...otherProps}) => (
	<FieldBaseProxy {...otherProps} name={name}>
		<Paragraph name={name} text={text} />
	</FieldBaseProxy>
));

const ReactParagraphAdapter = getConnectedReactComponentAdapter(
	ParagraphProxy,
	templates
);

export {ReactParagraphAdapter};
export default ReactParagraphAdapter;
