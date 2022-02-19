import styles from './index.css';
import {useState,useEffect} from 'react';
import { formatMessage } from 'umi-plugin-locale';
import * as THREE from 'three'
import { PCDLoader } from 'three/examples/jsm/loaders/PCDLoader.js';
import { OrbitControls } from 'three/examples/jsm/controls/OrbitControls.js';
let camera, scene, renderer;

function init() {

  renderer = new THREE.WebGLRenderer({ antialias: true });
  renderer.setPixelRatio(window.devicePixelRatio);
  renderer.setSize(1920, 1080);
  var container = document.getElementById("qt");
  container.appendChild(renderer.domElement);
  
  scene = new THREE.Scene();

  camera = new THREE.PerspectiveCamera(30, 1920 / 1080, 0.01, 40);
  camera.position.set(100, 100, 100);
  scene.add(camera);

  const controls = new OrbitControls(camera, renderer.domElement);
  controls.addEventListener('change', render); // use if there is no animation loop
  controls.minDistance = 0.5;
  controls.maxDistance = 10;

  //scene.add( new THREE.AxesHelper( 1 ) );

  const loader = new PCDLoader();
  var url = "http://localhost:8080/files/rgb.pcd"
  loader.load(url, function (points) {
    points.geometry.center();
    points.geometry.rotateX(Math.PI);
    points.scale.multiplyScalar( 0.1 );
          
    scene.add(points);
    render();

  });

  window.addEventListener('resize', onWindowResize);

  window.addEventListener('keypress', keyboard);

}
function onWindowResize() {

  camera.aspect = window.innerWidth / window.innerHeight;
  camera.updateProjectionMatrix();

  renderer.setSize(window.innerWidth, window.innerHeight);

}

function keyboard(ev) {

  const points = scene.getObjectByName('rgb.pcd');

  // eslint-disable-next-line default-case
  switch (ev.key || String.fromCharCode(ev.keyCode || ev.charCode)) {

    case '+':
      points.material.size *= 1.2;
      break;

    case '-':
      points.material.size /= 1.2;
      break;

    case 'c':
      points.material.color.setHex(Math.random() * 0xffffff);
      break;

  }

  render();

}

function render() {

  renderer.render(scene, camera);
  console.log("OK")

}




export default function() {
  useEffect(() => {
    init()
  }, []);
  return (
    <div className={styles.normal}>
      <div className={styles.welcome} />
      <ul className={styles.list}>
      <div id='qt' ></div>
        <li>To get started, edit <code>src/pages/index.js</code> and save to reload.</li>
        <li>
          <a href="https://umijs.org/guide/getting-started.html">
            {formatMessage({ id: 'index.start' })}
          </a>
        </li>
      </ul>
     
    </div>
  );
}
