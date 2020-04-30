/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import './SeparatorRegister.soy';

import React, {useEffect, useRef} from 'react';

import {FieldBaseProxy} from '../FieldBase/ReactFieldBase.es';
import getConnectedReactComponentAdapter from '../util/ReactComponentAdapter.es';
import {connectStore} from '../util/connectStore.es';
import templates from './SeparatorAdapter.soy';

const Separator = ({style}) => {
	const elRef = useRef(null);

	useEffect(() => {
		if (elRef.current) {
			// The style is a string, to avoid creating a normalizer to generate compatibility
			// with React, we can just add the raw value in the attribute, we don't need to
			// worry about XSS here because it won't go to the server just for printing
			// on the screen.
			elRef.current.setAttribute('style', style);
		}
	}, [style]);

	return <div className="separator" ref={elRef} />;
};

const SeparatorProxy = connectStore(({style, ...otherProps}) => (
	<FieldBaseProxy {...otherProps}>
		<Separator style={style} />
	</FieldBaseProxy>
));

const ReactSeparatorAdapter = getConnectedReactComponentAdapter(
	SeparatorProxy,
	templates
);

export {ReactSeparatorAdapter};
export default ReactSeparatorAdapter;
