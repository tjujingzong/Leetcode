#version 330 core
layout(location = 0) in vec3 position;
layout(location = 1) in vec3 normal;
uniform mat4 projection;
uniform mat4 view;
uniform mat4 model;
out vec3 FragNormal;
out vec3 FragPos;
void main()
{
    gl_Position = projection * view * model * vec4(position, 1.0);
    FragPos = vec3(model * vec4(position, 1.0));    // 在世界坐标系中指定
    mat3 normalMatrix = mat3(transpose(inverse(model)));
    FragNormal = normalMatrix * normal; // 计算法向量经过模型变换后值
}