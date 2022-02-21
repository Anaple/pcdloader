import styles from './index.css';
import 'antd/dist/antd.css';
import {useState,useEffect} from 'react';
import { Button, Radio,message,Progress,Card } from 'antd';
import { Input, Space } from 'antd';
import * as THREE from 'three'
import { PCDLoader } from 'three/examples/jsm/loaders/PCDLoader.js';
import { OrbitControls } from 'three/examples/jsm/controls/OrbitControls.js';
let camera, scene, renderer;


function onWindowResize() {

  camera.aspect = window.innerWidth / window.innerHeight;
  camera.updateProjectionMatrix();
  renderer.setSize(window.innerWidth, window.innerHeight);

}


function render() {

  renderer.render(scene, camera);
 

}



const { Search } = Input;

export default function() {
  useEffect(() => {
    init("http://192.168.0.204:8080/files/rgb.pcd");
    render();
  }, []);

  
  const [progress, setProgcress] = useState(0);
  const [cardShow, setCardShow] = useState(true);
 /**
获取当前分辨率动态调整卡片展示
 */



  const sysCard = () => {
    console.log(cardShow)
    if(cardShow){
      return(
      <Card title="状态" bordered={false} extra={<a onClick={()=>setCardShow(false)}>x</a>} style={{ width: 300 }}>
      <Progress percent={progress} />
      <Search
      placeholder="input pcdflie url "
      allowClear
      enterButton="submit"
      size="large"
      onSearch={(value)=>{document.getElementsByTagName("canvas")[0].remove();init(value);render()}}
    
    />
      <p>{window.navigator.userAgent}</p>
      {/* <Button style={{width:40,height:40,marginRight:5}}>+</Button>
      <Button style={{width:40,height:40}}>-</Button> */}
    </Card>
      )
    }else{
      return(
        <>

        <Button className={styles.btn} size='large' onClick={() => { setCardShow(true); } }> <Progress percent={progress} />+</Button>
        
        </>
      )
    }
    
  }

  function init(openurl) {
    var container = document.getElementById("qt");
    
    renderer = new THREE.WebGLRenderer({ antialias: true });
    renderer.setPixelRatio(window.devicePixelRatio);
    renderer.setSize(window.innerWidth , window.innerHeight );
    container.appendChild(renderer.domElement);
    
    scene = new THREE.Scene();
  
    camera = new THREE.PerspectiveCamera( 45, window.innerWidth / window.innerHeight, 1, 1000 );
  
    camera.position.set( 0, 0, 600 );
    camera.up.set(0,1,0)
  
    scene.add( camera );
  
    const controls = new OrbitControls( camera, renderer.domElement );
    controls.addEventListener( 'change', render ); // use if there is no animation loop
    
    controls.minDistance = 0.5;
    controls.maxDistance =100;
    //controls.minPolarAngle = Math.PI;
    controls.minAzimuthAngle = 2*Math.PI
  
    const loader = new PCDLoader();
    var url = openurl
  try{
    loader.load(url, function (points) {
      points.geometry.center();
      points.geometry.rotateX(Math.PI);
      points.scale.multiplyScalar( 0.3 );
      scene.add(points);
      render();
  
    },(xhr)=>{
      setProgcress(Math.floor(xhr.loaded/xhr.total*100))
    });
  }catch(err){
    message.error({content:err,duration:1})
  }
  
    window.addEventListener('resize', onWindowResize);
  
  
  }

  return (
    <div id='qt' >
      <div className={styles.info}>
      {sysCard()}
      </div>      
    </div>
  );
}
