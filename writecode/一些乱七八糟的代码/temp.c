if (time < 40)
  tortoiseMatrix = glm::translate(tortoiseMatrix, glm::vec3(-3.0, -2.0 + bezier(time / 40), -2.0 + time));
//模型沿z轴正方向运动，y轴方向为地形起伏
else
  tortoiseMatrix = glm::translate(tortoiseMatrix, glm::vec3(-3.0, -2.0, 38.0));