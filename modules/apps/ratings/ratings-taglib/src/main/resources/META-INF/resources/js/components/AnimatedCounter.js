/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import classNames from 'classnames';
import {useIsMounted} from 'frontend-js-react-web';
import PropTypes from 'prop-types';
import React, {useEffect, useRef, useState} from 'react';

function usePrevious(value) {
	const ref = useRef();

	useEffect(() => {
		ref.current = value;
	});

	return ref.current;
}

function SlidingText({current, previous}) {
	const [animating, setAnimating] = useState(false);
	const direction = current > previous ? 'up' : 'down';
	const isMounted = useIsMounted();
	const maxLength = current.toString().length + 1;

	const finishAnimation = () => {
		if (isMounted) {
			setAnimating(false);
		}
	};

	useEffect(() => {
		if (
			Number.isInteger(current) &&
			Number.isInteger(previous) &&
			current !== previous
		) {
			setAnimating(true);
		}
	}, [current, previous]);

	return (
		<span
			className={classNames('animated-counter', {
				[`animating-${direction}`]: animating,
			})}
			onAnimationEnd={finishAnimation}
			style={{
				minWidth: `${maxLength}ch`,
			}}
		>
			<span className="current">{current}</span>
			{animating && <span className="previous">{previous}</span>}
		</span>
	);
}

function AnimatedCounter({counter}) {
	const prevCounter = usePrevious(counter);

	return <SlidingText current={counter} previous={prevCounter} />;
}

AnimatedCounter.propTypes = {
	counter: PropTypes.number.isRequired,
};

export default AnimatedCounter;
