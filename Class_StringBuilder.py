# Part 1: Generate alphabet from 'a' to 'z'
sb = []
for ch in range(ord("a"), ord("z") + 1):
  sb.append(chr(ch))
print("".join(sb))
    

# Part 2: Capitalize the first letter and letters after a space
letter = list("hi, i am shraddha")
letter[0] = letter[0].upper()
for i in range(1, len(letter)):
  if letter[i] == " ":
    next_char = letter[i + 1]
    letter[i + 1] = next_char.upper()
print("".join(letter))

    
# Part 3: String compression (Run-Length Encoding)
str_val = "aaabbcccdd"
compress = ""
i = 0
while i < len(str_val):
  count = 1
  while i < len(str_val) - 1 and str_val[i] == str_val[i + 1]:
    count += 1
    i += 1
  compress += str_val[i]
  if count > 1:
    compress += str(count)
  i += 1
print(compress)
